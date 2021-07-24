Role Based Access Control:
------------------------------
Sample Roles     : ADMIN,DEVELOPER,MANAGER,QA
Sample resources : ALL,PROD,DEV,PREPROD,QA
Sample Action    : ALL,READ,WRITE,DELETE

--------------------------------------------
Entity Details:

Each Role have access on particular resource and can take action on resources
So created a RolePermision Entity which is a combination of role,action and resource.

Users would have a list of assigned roles, based on assigned role one can get the RolePermission
for a particular role and check user have access on resources or not.

---------------------------------------------------
Service Details:

Using RolePermissionService,one can create RolePermission for particular role.

Using UserService, one can create User,Provide role to user and remove role from user.

-----------------------------------------------------
Repository Details:

RolePermissionRepository contains the in memory list of RolePermission and could be extended With DB.
UserService contains the in memory list of all the user with assigned roles and could also be extended with DB.

-----------------------------------------------------

User ---> UserRoles--->
Role --> (Access)Action & Resource


    

 