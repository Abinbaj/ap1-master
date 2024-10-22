# NIT3213 Project - Exercise App

## Key Features

### 1. **Login Functionality**
- **Simple Login**: Enter your credentials to authenticate. For testing, you can use:
  - **Username**: `Abin`
  - **Password**: `s4675959`
  
- The app checks your username and password with an API and retrieves a `keypass` that grants access to other features.

**API Authentication Endpoint**:
- **POST** `/footscray/auth`
  - Returns a `keypass` upon successful login.
  - _Note_: You may need to attempt the login process two or three times due to API response times.

---

### 2. **Dashboard**
- **Entity List**: Once logged in, the dashboard displays a list of exercises fetched from the API.
- Each entry includes an image and basic information about the exercise.

**API Fetch Endpoint**:
- **GET** `/dashboard/{keypass}`
  - Retrieves the list of exercises using the `keypass` received during login.

---

### 3. **Exercise Details**
- **Detailed View**: Click on any exercise in the dashboard to view more information, such as:
  - Name
  - Description
  - Muscle Group
  - Equipment
  - Calories Burned
  - Difficulty Level
  - An image of the exercise
  
- The details page shows all relevant data along with an associated image.

---

### 4. **Unit Testing**
- Basic unit tests are included to validate the login process and ensure that the app interacts with the API correctly.

- The tests are located in:
  - `app/src/test/java/com/example/ap1` (GitHub)
  - `app:kotlin+java:com.example.ap1` (Android Studio)

---

## Project Structure

### **Source Code**:
- **Package**: `com.example.ap1`
  - Located at: `app/src/main/java/com/example/ap1` (GitHub)
  - Located at: `app:kotlin+java:com.example.ap1` (Android Studio)
  - Contains all the Activity files and network/API files.

### **Layouts and UI**:
- **Resource Folder**:
  - Located at: `app/src/main/res` (GitHub)
  - Located at: `app/res` (Android Studio)
  - Contains all the UI-related files like layout files for the user interface.

### **Testing**:
- **Unit Tests**:
  - Located at: `app/src/test/java/com/example/ap1` (GitHub)
  - Includes tests for login functionality and API interactions.

---

## Installation

### What You Need
1. **Android Studio**: Ensure you have Android Studio installed to run the project.
2. **API Access**: Make sure you can access the relevant APIs.

### Installation Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Abinbaj/ap1-master.git
