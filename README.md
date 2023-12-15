
# Myntra App Backend Development Documentation

## Project Overview

This repository contains the backend development codebase for the Myntra app. The backend is implemented using Java programming language and utilizes SQL for database management. This documentation provides information about the language and database details used in the project, as well as the installation procedure to set up the backend environment.

## Language and Database Details

### Java

The backend of the Myntra app is developed using Java, a versatile and robust programming language. Java was chosen for its platform independence, object-oriented nature, and extensive community support. The codebase follows best practices and design patterns to ensure maintainability and scalability.

### SQL

Structured Query Language (SQL) is employed for managing the database of the Myntra app. SQL is a standard language for interacting with relational databases and it offers a powerful and efficient way to handle data. The backend uses SQL queries to perform operations such as data retrieval, insertion, and modification.

## Installation Procedure

To set up the backend environment for the Myntra app, follow these steps:
## Installation Procedure

### Install Java (JDK 17)

1. **Download JDK:**
   - Visit [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) to download the latest version of the Java Development Kit (JDK).

2. **Install JDK:**
   - Follow the installation instructions provided for your operating system on the Oracle website.

3. **Set Environment Variables (Optional but recommended):**
   - Set the `JAVA_HOME` environment variable to point to the JDK installation directory. Add the `bin` directory to the system `PATH` variable.

### Install MySQL (Latest Version)

1. **Download MySQL:**
   - Visit [MySQL Downloads](https://dev.mysql.com/downloads/) to download the latest version of MySQL.

2. **Select Installer:**
   - Choose the appropriate installer for your operating system (e.g., MySQL Installer for Windows, MySQL Community Server for Linux).

3. **Follow Installation Wizard:**
   - Run the downloaded installer and follow the installation wizard. Select at least the MySQL Server component.

4. **Configure MySQL Server:**
   - Set a root password and configure other settings during the installation.

5. **Complete Installation:**
   - Complete the installation process. The installer will set up MySQL Server as a service on Windows or start it on Linux.

6. **Verify Installations:**
   - Open a command prompt or terminal and run `java -version` to verify Java installation.
   - Run `mysql --version` to verify MySQL installation.

### Verify Java and MySQL

1. **Verify Java Installation:**
   - Open a command prompt or terminal and run `java -version`.

2. **Verify MySQL Connection:**
   - Open a command prompt or terminal and run `mysql -u root -p`. Enter the root password when prompted.

With Java and MySQL successfully installed, you can proceed with setting up your Myntra app backend, as outlined in the project's README file. Ensure that you update the database connection settings in your application accordingly.

### Project Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SINDHUK2003/myntra-backend.git

   
