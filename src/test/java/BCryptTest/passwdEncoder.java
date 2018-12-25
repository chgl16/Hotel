package BCryptTest;

import org.junit.Test;
import com.lusr.util.BCrypt;

public class passwdEncoder {
    @Test
    public void test() {
        String shadow = BCrypt.hashpw("mima",  BCrypt.gensalt(10));
        // $2a$10$tzwtDIvZVlx2SRrBVeGHnOEktyYX6PgHBM9C0Kl3rQL0NemNRUUQO
        System.out.println(shadow);
        boolean flag = BCrypt.checkpw("mima", "$2a$10$tzwtDIvZVlx2SRrBVeGHnOEktyYX6PgHBM9C0Kl3rQL0NemNRUUQO");
        System.out.println(flag);
    }
}
