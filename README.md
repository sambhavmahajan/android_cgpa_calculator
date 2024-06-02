# CGPA Calculator

This repository contains an Android application that calculates the CGPA (Cumulative Grade Point Average) for students. It allows users to add subjects with corresponding grades and credits, and then computes the CGPA based on the input.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- Add subjects with name, grade, and credit.
- Remove subjects by index or remove the most recent one.
- Clear all subjects.
- Display the current GPA and total number of subjects.
- Responsive UI with Material Design components.

## Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/sambhavmahajan/cgpacalc.git
    cd cgpacalc
    ```

2. **Open the project in Android Studio:**

    - Open Android Studio.
    - Select `File -> Open...` and navigate to the cloned repository.
    - Click `OK` to open the project.

3. **Build and run the project:**

    - Connect an Android device or start an emulator.
    - Click the `Run` button in Android Studio.

## Usage

1. **Add a Subject:**

    - Enter the subject name, grade, and credit in the respective input fields.
    - Click the `Add` button to add the subject to the list.

2. **Remove a Subject:**

    - To remove a subject by index, enter the index (starting from 0) in the `Index` field and click the `Remove` button.
    - To remove the most recent subject, click the `Remove recent` button.

3. **Clear All Subjects:**

    - Click the `Clear` button to remove all subjects from the list.

4. **View GPA:**

    - The current GPA and the total number of subjects are displayed below the subject list.

## Code Overview

### XML Layout

The XML layout defines the UI of the application, using a `ConstraintLayout` to arrange the components. It includes:

- `TextInputLayout` and `TextInputEditText` for input fields.
- `Button` components for actions (Add, Remove, Clear).
- `TextView` components to display the subject list and GPA.

### MainActivity

The `MainActivity` class contains the logic for the application, including:

- Adding, removing, and clearing subjects.
- Calculating the GPA.
- Updating the UI based on the current list of subjects.

### Subject Class

The `Subject` class represents a subject with its name, grade, and credit. It includes a method to convert grades to marks based on a predefined scale.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

© 2024 Sambhav Mahajan. All rights reserved.
