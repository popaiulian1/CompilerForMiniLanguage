using System;
using System.Collections.Generic;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;

public class SyntaxCollector : MiniLangBaseVisitor<object>
{
    private HashSet<string> _globalVarNames = new HashSet<string>();
    private HashSet<string> _functionNames = new HashSet<string>();
    private HashSet<string> _definedFunctions = new HashSet<string>();
    private readonly Dictionary<string, string> _functionReturnTypes = new Dictionary<string, string>();
    private readonly List<string> globalVariables = new List<string>();
    private readonly List<string> functions = new List<string>();

    public override object VisitDeclaration(MiniLangParser.DeclarationContext context)
    {
        string type = context.type().GetText();

        // Iterate through identifiers in the declaration
        foreach (var identifier in context.identifier())
        {
            string name = identifier.GetText();
            string value = "null";  // Default value if no assignment

            // Check if the declaration has an assignment (ASSIGN expression)
            if (context.ASSIGN() != null)
            {
                // If assignment exists, fetch the expression associated with it
                var expression = context.expression(); 
                value = expression != null ? expression[0].GetText() : "null";
            }

            if (!IsTypeCompatible(type, value))
            {
                Console.WriteLine($" = Error: Incompatible type for variable '{name}', expected '{type}', got '{value}' = ");
            }

            if (!_globalVarNames.Contains(name))
            {
                _globalVarNames.Add(name);
                globalVariables.Add($"<Type: {type}, Name: {name}, Value: {value}>");
            }
            else
            {
                Console.WriteLine($" = Conflict: Global variable {name} already exists = ");
            }
            
        }
        return null;
    }
    
    public override object VisitFunctionDefinition(MiniLangParser.FunctionDefinitionContext context)
    {
        string type = context.type().GetText();
        string name = context.identifier().GetText();
        string parameters = context.parameterList()?.GetText() ?? "None";
        _functionReturnTypes[name] = type;
        string isRecursive = IsRecursive(context) ? "Recursive" : "Iterative";
        string isMain = name == "main" ? "Main" : "Non-Main";
        
        var localVars = new List<string>();
        HashSet<string> _localVarNames = new HashSet<string>();
        
        var controlStructures = new List<string>();
    
        // Visit each statement in the block
        foreach (var statement in context.block().statement())
        {
            // Check for declarations
            if (statement.declaration() != null)
            {
                ProcessDeclaration(statement.declaration(), localVars, _localVarNames, parameters, name);
            }
            // Check for control structures
            else if (statement.ifStatement() != null)
            {
                string statementText = statement.ifStatement().GetText();
                if (statementText.Contains("else"))
                {
                    controlStructures.Add($"<Structure: If..Else, Line: {statement.Start.Line}>");
                }
                else
                {
                    controlStructures.Add($"<Structure: If, Line: {statement.Start.Line}>");
                }
            }
            else if (statement.forStatement() != null)
            {
                controlStructures.Add($"<Structure: For, Line: {statement.Start.Line}>");
            }
            else if (statement.whileStatement() != null)
            {
                controlStructures.Add($"<Structure: While, Line: {statement.Start.Line}>");
            }
        }

        if (!_functionNames.Contains(type + name + parameters))
        {
            _functionNames.Add(type + name + parameters);
            _definedFunctions.Add(name);
            functions.Add(
                $"Function:\n" +
                $"  <Type: {type}, Name: {name}, Parameters: ({parameters}), FunctionType: {isRecursive}, Main: {isMain}>\n" +
                $"  Local Variables: \n\t{string.Join(",\n\t", localVars)}\n" +
                $"  Control Structures: \n\t{string.Join(",\n\t", controlStructures)}\n"
            );
        }
        else
        {
            Console.WriteLine($" = Conflict: Function {type} {name} ({parameters}) already exists =");
        }
    
        return null;
    }
    
    public override object VisitFunctionCall(MiniLangParser.FunctionCallContext context)
    {
        string functionName = context.identifier().GetText();

        if (!_definedFunctions.Contains(functionName))
        {
            Console.WriteLine($" = Conflict: Function {functionName} is called but not defined =");
        }
        
        return base.VisitFunctionCall(context);
    }
    
    private void ProcessDeclaration(MiniLangParser.DeclarationContext declaration, List<string> localVars, HashSet<string> _localVarNames, string parameters, string functionName)
    {
        string type = declaration.type().GetText();
        foreach (var identifier in declaration.identifier())
        {
            string name = identifier.GetText();
            string value = "Unassigned"; // Default value
    
            // Check if an assignment exists
            if (declaration.expression() != null && declaration.expression().Length > 0)
            {
                value = declaration.expression()[0].GetText(); 
            }

            if (value != "Unassigned" && !IsTypeCompatible(type, value))
            {
                Console.WriteLine($" = Error: Incompatible type for variable '{name}', expected '{type}', got '{value}' = ");
                continue;
            }

            if (parameters.Contains(name))
            {
                Console.WriteLine($" = Conflict: Local variable '{name}' conflicts with a parameter in function : '{functionName}' = ");
                continue;
            }
            
            if (!_localVarNames.Contains(name))
            {
                _localVarNames.Add(name);
                localVars.Add($"<Type: {type}, Name: {name}, Value: {value}>");
            }
            else
            {
                Console.WriteLine($" = Conflict: Local variable '{name}' already exists in function : '{functionName}' = ");
            }
        }
    }

    private bool IsTypeCompatible(string type, string? value)
    {
        if (value == null) return true;

        if (value.Contains("(") && value.Contains(")"))
        {
            string functionName = value.Split('(')[0];
            if (_functionReturnTypes.ContainsKey(functionName))
            {
                return _functionReturnTypes[functionName] == type;
            }
            else
            {
                Console.WriteLine($" = Error: Function {functionName} is not defined = ");
                return false;
            }
        }

        switch (type)
        {
            case "int":
                return int.TryParse(value, out _);
            case "float":
            case "double":
                return double.TryParse(value, out _);
            case "string":
                return value.StartsWith("\"") && value.EndsWith("\"");
            default:
                return false;
        }
    }

    private bool IsRecursive(MiniLangParser.FunctionDefinitionContext context)
    {
        string functionName = context.identifier().GetText();
        return context.block().GetText().Contains(functionName);
    }

    public void SaveGlobalVariables(string filePath)
    {
        File.WriteAllLines(filePath, globalVariables);
    }

    public void SaveFunctions(string filePath)
    {
        File.WriteAllLines(filePath, functions);
    }
}
