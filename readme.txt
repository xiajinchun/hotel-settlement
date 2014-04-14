                       Java Hotel Settlement Application
                       =================================

Welcome to the Java Hotel Settlement application, a desktop application using Java programming language. It is used to manage and settle daily earnings for small hotel, is also substitute for traditional means by manually. Actually, I write this application for my family hotel.

Application contains four main functions that Query, Check In, Check Out and Settlement. And it allows to add different room information(Room Number, Room Type, Room Price) through right format that show in classes/data/room.txt file. The daily record will generate a record file in classes/data/ folder, and it named as current date like ’yyyy-mm-dd’.

Query
—————

A panel to show all record information according selected date.

Check In
————————

A panel to add new check-in record. When this panel is opening, application will read room information and chose or input some other information(e.g Customer Name, Price and Pledge), then pressed submit button to save.

Check Out
—————————

A panel to modify check-in record when customer checking out, application will read uncheck out item and chose room number, then show the detail and pressed check out button to modify.


Settlement
—————————

A panel to show a day statistical information according selected date. And it can also show the statistical information by selected room type.

Installation
============

Download sources code and enter application folder, type in ’mvn package‘, then a runnable jar file will generate in target folder. Double click this jar file and appellation will run!

Have fun!

Charles Hsia.
