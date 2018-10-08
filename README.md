# taskilist-api

### View all items in the list
     /tasks
**Request (GET)**
  * No Parameters
  
**Response (JSON)**
  * All item in the list
    * Subject of task (string)
    * Detail (string)
    * Status of task (string) 
      
          Path: localhost:9999/tasks
          [
          {
              "subjectOfTask": "Task",
                "detailOfTask": "Add New Task",
                "statusOfTask": "Done"
          },
          {
                "subjectOfTask": "NewTask",
                "detailOfTask": "Edit New Task",
                "statusOfTask": "Pending"
          },
          ]

### View a single task in the list
     /tasks/ {subject of task}
**Request (GET)**
  * No Parameters
  
**Response (JSON)**
  * Single  task in list
    * Subject of task (string)
    * Detail (string)
    * Status of task (string) 
      
          Path: localhost:9999/tasks/NewTask
          {
                "subjectOfTask": "NewTask",
                "detailOfTask": "Edit New Task",
                "statusOfTask": "Pending"
          }

### Add a task to the list
     /create
**Request (POST, JSON body)**
  * Subject of task (string)
  * Detail (string)
  * Status of task (string)

          {
                "subjectOfTask": "Create",
                "detailOfTask": "New Task",
                "statusOfTask": "Pending"
          }


**Response (JSON)**
  * All item in the list
    * Subject of task (string)
    * Detail (string)
    * Status of task (string) 
      
          Path: localhost:9999/create
          [
          {
                "subjectOfTask": "Task",
                "detailOfTask": "Edit New Task",
                "statusOfTask": "Pending"
          },
          {
                "subjectOfTask": "Create",
                "detailOfTask": "New Task",
                "statusOfTask": "Pending"
          }
          ]

### Edit existing task
     /update/{subject of task}
**Request (PUT, JSON body)**
  * Subject of task (string)
  * Detail (string)
  * Status of task (string)

          {
                "subjectOfTask": "Task",
                "detailOfTask": "Edit",
                "statusOfTask": "Pending"
          }


**Response (JSON)**
  * All item in the list
    * Subject of task (string)
    * Detail (string)
    * Status of task (string) 
      
          Path: localhost:9999/update/Task
          [
          {
                "subjectOfTask": "Task",
                "detailOfTask": "Edit",
                "statusOfTask": "Pending"
          },
          {
                "subjectOfTask": "NewTask",
                "detailOfTask": "Add New Task",
                "statusOfTask": "Pending"
          }
          ]

### Set the task status
     /updatestatus/{subject of task}
**Request (PUT, JSON body)**
  * Status of task (string)

          {
                "statusOfTask": "Done"
          }

**Response (JSON)**
  * All item in the list
    * Subject of task (string)
    * Detail (string)
    * Status of task (string) 
      
          Path: localhost:9999/updatestatus/Task
          [
          {
                "subjectOfTask": "Task",
                "detailOfTask": "Edit",
                "statusOfTask": "Done"
          },
          {
                "subjectOfTask": "NewTask",
                "detailOfTask": "Add New Task",
                "statusOfTask": "Pending"
          }
          ]

### Delete a task from the list
     /delete/{subject of task}
**Request (DELETE)**
  * No Parameters
  
**Response (NONE)**
  * None
      
          Path: localhost:9999/updatestatus/Task
          [
          {
                "subjectOfTask": "NewTask",
                "detailOfTask": "Add New Task",
                "statusOfTask": "Pending"
          }
          ]
