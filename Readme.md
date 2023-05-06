## Proposal

### Title: Bon Appetit

### **Group Members**

Yuejia Yin Yujie Zhu       

### **Introduction**

Sometimes we need some idea about some "fresh" idea about recipes and favorites or upload our recipes. So this is a **recipe management system** where users can search, post, favorite, rate, and leave comments on recipes.

### **Goals**

1. Users who choose *guest*(not registered) can only search for certain 100 recipes.
2. *Registered* users can search, favorite, rate, and leave comments on all recipes, and upload their own recipes.
3. Each recipe has several *tags*, such as *appetizers*, *seafood*, etc. 
4. Registered users can search for the names and tags.
5. Registered users can search by the filter, such as *cooking time*, *calories*, *ingredients*, etc.
6. The search results will be displayed in decreasing order of the number of likes.
7. The clients can request the server to add, delete, and modify the data uploaded by clients.
8. The server will recommend similar recipes based on the user's favorite records.

### System Architecture

GUI: Using Swing; having login frame, register frame, search frame, upload frame and user homepage frame.

Database management using JDBC.

Client and server communication: TCP socket

Data source: https://github.com/tabatkins/recipe-db from GitHub.

