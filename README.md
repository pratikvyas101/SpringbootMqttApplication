# SpringbootMqttApplication
Monitoring the live data of vehicle and control state of vehicle 
Vehicle Diagnostics and Monitoring System 🚗📊
This project is a Vehicle Diagnostics and Monitoring System that enables real-time tracking of critical vehicle states, such as door status, fuel level, AC condition, engine health, and much more. Designed for web and mobile platforms, it provides an intuitive interface for accessing vehicle data, performing diagnostic tests, and making informed decisions based on actionable insights.

🚀 Features
✅ Real-Time Monitoring
Track real-time vehicle parameters:
Door Status: Open/Closed.
Fuel Level: Current fuel percentage.
AC Condition: On/Off status.
Engine Temperature and health.
Battery Status and health.
Tire Pressure Monitoring.
✅ Diagnostics Overview
Comprehensive health check of key vehicle systems.
View diagnostic trouble codes (DTCs) with detailed descriptions.
Perform diagnostic tests on vehicle components (e.g., engine test, battery test).
✅ Historical Data and Trends
Log and display historical diagnostics data.
Graphical representation of:
Engine temperature trends.
Fuel usage patterns.
Vehicle error history.
✅ Alerts and Notifications
Receive real-time alerts for critical errors or warnings.
Visual indicators for healthy, warning, or critical states of components.
✅ User Management
Role-Based Access Control:
Driver, Owner, Admin roles.
Secure user authentication and logout system.
✅ Interactive Dashboard
Responsive UI with charts, graphs, and status indicators.
Designed for desktop and mobile platforms.
✅ Maintenance Recommendations
Preventive maintenance suggestions based on diagnostic data.
Example: Oil changes, battery replacements, or tire checks.
🛠️ Technologies Used
Backend
Java: Core development language.
Spring Boot: Framework for building REST APIs and handling backend logic.
Spring Security: For user authentication and role-based access.
MQTT Protocol: For real-time data fetching and communication.
Frontend
Thymeleaf: Template engine for rendering dynamic web pages.
Bootstrap: For responsive UI design.
JavaScript: For interactive features and dynamic content rendering.
Database
H2 Database (or any SQL database): For storing user and historical diagnostic data.
⚙️ How It Works
Login System:
Users log in to the system with secure credentials. Based on roles (Driver, Owner, Admin), users access specific features.

Real-Time Data Fetching:
The application uses MQTT protocol to fetch live vehicle data and display it on the dashboard.

Diagnostics Page:

Displays real-time status of components.
Allows users to initiate diagnostic tests.
Shows detailed error codes with descriptions.
Historical Data Visualization:
Users can view past diagnostic results and trends, such as fuel levels and error logs.

Logout:
Users can securely log out of the system. Upon logout, a success message is displayed.
