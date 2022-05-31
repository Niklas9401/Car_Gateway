package de.cargateway.web.security;

import de.cargateway.web.entity.Role;
import de.cargateway.web.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    // TODO müssen wir prüfen, ob das userThreadLocal den richtigen Wert hat?

    private final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public void authenticate(String token) {
        Object tokenObject = validateAndParseJWT(token); // TODO typ ändern
        // User user = null; // TODO datenbank abfrage machen mit dem username aus tokenObject

        // dummy, Hund mit Brille
        User user = new User(null, "Niklas Weiblen", "niklas_w", "ichbindumm", Arrays.asList(new Role(null, "ROLE_ADMIN")));
        this.userThreadLocal.set(user);
    }

    public User getCurrentUser() {
        return this.userThreadLocal.get();
    }

    // für diese methode gibts auch ne bibliothek
    private Object validateAndParseJWT(String token) {
        // token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcm5hbWUiOiJuaWtsYXNfdyIsImlhdCI6MTUxNjIzOTAyMn0.iv_pI-C29U0cCJxU84pvSXmHKk9KjmH5amFFh7FkCh0";
        // TODO jwt verifizieren
        // TODO jwt decodieren (base64)

        // decodedTokenPayload = "{
        //  "sub": "1234567890",
        //  "username": "niklas_w",
        //  "iat": 1516239022
        //}";
        // TODO json parsen und dann username rausholen
        return null;
    }
}
