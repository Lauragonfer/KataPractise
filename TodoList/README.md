## Todo task list
### Exercise
Write a todo list application that allow users to:
1. Enter a task to be completed specifying the task and due date.  
Task constraints:
   - Task name length: 5 - 20 characters
   - Task name can only contain alphanumeric characters (letters A-Z, numbers 0-9) and blank spaces.  

    For simplicity save your data to a text file in csv format or in memory:  
  todo.exe task -t Complete Application -d 2018-04-01 
  
2. List task specifying the status of the task. The available task status are: All or Incomplete. Incomplete will only show task not marked as completed.  
   - todo.exe list -s [All| Incomplete]  
   - The output should be in the following format:

     Id: 1  
    Task: Complete Application  
    Due: 2018-04-01

3. Mark a task as complete by passing in the task Id.  
todo.exe -c [Id]

*Hint:*
Only worry about writing the library code to facilitate the todo list. There is no need to parse the arguments.

### Bonus
1. Allow user to create sub-task for an existing task. Do this by amending the create function to take in a parent task Id.  
    - todo.exe task -t Sub Task -d 2018-04-02 -p 1   
2. Task list output will list all sub-task under the parent task
    - Do not show the  > Child Task <  header when task has no children
    - Output example:
    
      Id: 1  
      Task: Complete Application  
      Due: 2018-04-01  
      \> Child task \<
      Id: 2  
      Task: List all task  
      Due: 2018-04-02  
      
3. Print an error if the user tries to mark the parent task as complete without all children task being marked as complete already.


