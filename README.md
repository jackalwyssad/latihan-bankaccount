# Latihan BankAccount - Unit Testing & GitHub Actions

Project studi kasus implementasi Unit Testing (JUnit 5) dan CI/CD Pipeline (GitHub Actions) dengan Code Coverage (JaCoCo).

## Identitas
- **Nama**: Jacky Firmansah
- **NIM**: 1224010
- **Mata Kuliah**: Implementasi Pengujian Perangkat Lunak

## Fitur BankAccount
- `deposit(double amount)`: Menambah saldo (validasi amount >= 0)
- `withdraw(double amount)`: Mengurangi saldo (validasi amount >= 0 dan saldo mencukupi)
- `getBalance()`: Mengembalikan saldo rekening

## Pipeline CI/CD (GitHub Actions)
1. Checkout code
2. Setup Java JDK 17
3. Run JUnit tests (`mvn test`)
4. Generate JaCoCo coverage report (`mvn jacoco:report`)
5. Upload artifact coverage (`jacoco-report`)
