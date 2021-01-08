-- Users
INSERT INTO project_hub_db.`Users` (FirstName, LastName, Username) VALUES ('Alex', 'Gordon', 'argordon');

-- Teams

-- Boards
INSERT INTO project_hub_db.`Boards` (Name) VALUES ('Project Hub Back End API');
INSERT INTO project_hub_db.`Boards` (Name) VALUES ('Project Hub Client');

-- UserBoards (JoiningTable)
INSERT INTO project_hub_db.`UserBoards` (UserId, BoardId) VALUES (1, 1);

-- Menus

-- Lists
INSERT INTO project_hub_db.`Lists` (BoardId, Name, SortOrder) VALUES (1, 'Backlog', 1);
INSERT INTO project_hub_db.`Lists` (BoardId, Name, SortOrder) VALUES (1, 'Defined', 2);
INSERT INTO project_hub_db.`Lists` (BoardId, Name, SortOrder) VALUES (1, 'In-Progess', 3);
INSERT INTO project_hub_db.`Lists` (BoardId, Name, SortOrder) VALUES (1, 'Complete', 4);

-- Cards
INSERT INTO project_hub_db.`Cards` (ListId, Title, Description) VALUES (1, 'Configure Auth Layer', 'Configure auth layer for security and access control');
INSERT INTO project_hub_db.`Cards` (ListId, Title, Description) VALUES (1, 'Create Spring Exception Handler', 'Create an exception handler to clean up the try/catch wet code in controller');
INSERT INTO project_hub_db.`Cards` (ListId, Title, Description) VALUES (3, 'Controller Methods', 'CRUD controller and service methods for client consumption');
