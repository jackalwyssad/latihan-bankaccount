import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private static final double DELTA = 0.001;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100);
    }

    @Test
    @DisplayName("TC1: Rekening baru tanpa saldo awal bernilai 0")
    void rekeningBaruTanpaSaldoAwal_saldoNol() {
        assertEquals(0, new BankAccount().getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC2: Saldo awal negatif melempar IllegalArgumentException")
    void saldoAwalNegatif_melemparException() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }

    @Test
    @DisplayName("TC3: Deposit berhasil menambah saldo")
    void deposit_menambahSaldo() {
        account.deposit(50);
        assertEquals(150, account.getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC4: Deposit 0 saldo tetap")
    void deposit_nol_saldoTetap() {
        account.deposit(0);
        assertEquals(100, account.getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC5: Deposit negatif melempar IllegalArgumentException")
    void deposit_negatif_melemparException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }

    @Test
    @DisplayName("TC6: Withdraw berhasil mengurangi saldo")
    void withdraw_mengurangiSaldo() {
        account.withdraw(40);
        assertEquals(60, account.getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC7: Withdraw sebesar saldo membuat saldo 0")
    void withdraw_sebesarSaldo_saldoMenjadiNol() {
        account.withdraw(100);
        assertEquals(0, account.getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC8: Withdraw negatif melempar IllegalArgumentException")
    void withdraw_negatif_melemparException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
    }

    @Test
    @DisplayName("TC9: Withdraw melebihi saldo melempar IllegalArgumentException dan saldo tetap")
    void withdraw_melebihiSaldo_melemparExceptionDanSaldoTidakBerubah() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.01));
        assertEquals(100, account.getBalance(), DELTA);
    }

    @Test
    @DisplayName("TC10: Beberapa transaksi berurutan menghitung saldo akhir dengan tepat")
    void beberapaTransaksiBerurutan_saldoAkhirBenar() {
        account.deposit(200);
        account.withdraw(50);
        account.deposit(25);
        assertEquals(275, account.getBalance(), DELTA);
    }
}
