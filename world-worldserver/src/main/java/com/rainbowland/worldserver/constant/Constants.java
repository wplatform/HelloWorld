package com.rainbowland.worldserver.constant;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public interface Constants {

    String SERVER_CONNECTION_HELLO = "WORLD OF WARCRAFT CONNECTION - SERVER TO CLIENT - V2";
    String CLIENT_CONNECTION_HELLO = "WORLD OF WARCRAFT CONNECTION - CLIENT TO SERVER - V2";


    int MIN_SIZE_FOR_COMPRESSION = 0x400;


    byte[] AUTH_CHECK_SEED = {(byte) 0xC5, (byte) 0xC6, (byte) 0x98, (byte) 0x95, 0x76, 0x3F, 0x1D, (byte) 0xCD, (byte) 0xB6, (byte) 0xA1, 0x37, 0x28, (byte) 0xB3, 0x12, (byte) 0xFF, (byte) 0x8A};
    byte[] SESSION_KEY_SEED = {0x58, (byte) 0xCB, (byte) 0xCF, 0x40, (byte) 0xFE, 0x2E, (byte) 0xCE, (byte) 0xA6, 0x5A, (byte) 0x90, (byte) 0xB8, 0x01, 0x68, 0x6C, 0x28, 0x0B};
    byte[] CONTINUED_SESSION_SEED = {0x16, (byte) 0xAD, 0x0C, (byte) 0xD4, 0x46, (byte) 0xF9, 0x4F, (byte) 0xB2, (byte) 0xEF, 0x7D, (byte) 0xEA, 0x2A, 0x17, 0x66, 0x4D, 0x2F};
    byte[] ENCRYPTION_KEY_SEED = {(byte) 0xE9, 0x75, 0x3C, 0x50, (byte) 0x90, (byte) 0x93, 0x61, (byte) 0xDA, 0x3B, 0x07, (byte) 0xEE, (byte) 0xFA, (byte) 0xFF, (byte) 0x9D, 0x41, (byte) 0xB8};
    byte[] ENABLE_ENCRYPTION_SEED = {(byte) 0x90, (byte) 0x9C, (byte) 0xD0, 0x50, 0x5A, 0x2C, 0x14, (byte) 0xDD, 0x5C, 0x2C, (byte) 0xC0, 0x64, 0x14, (byte) 0xF3, (byte) 0xFE, (byte) 0xC9};


    String RSA_PRIVATE_KEY = """
            -----BEGIN RSA PRIVATE KEY-----
            MIIEpAIBAAKCAQEA7rPc1NPDtFRRzmZbyzK48PeSU8YZ8gyFL4omqXpFn2DE683q
            f41Z2FeyYHsJTJtouMft7x6ADeZrN1tTkOsYEw1/Q2SD2pjmrMIwooKlxsvH+4af
            n6kCagNJxTj7wMhVzMDOJZG+hc/R0TfOzIPS6jCAB3uAn51EVCIpvoba20jFqfkT
            NpUjdvEO3IQNlAISqJfzOxTuqm+YBSdOH6Ngpana2BffM8viE1SLGLDKubuIZAbf
            dabXYQC7sFoOetR3CE0V4hCDsASqnot3qQaJXQhdD7gua8HLZM9uXNtPWGUIUfsN
            SBpvtj0fC93+Gx3wv7Ana/WOvMdAAf+nC4DWXwIDAQABAoIBACKa5q/gB2Y0Nyvi
            APrDXrZoXclRVd+WWxSaRaKaPE+vuryovI9DUbwgcpa0H5QAj70CFwdsd4oMVozO
            6519x56zfTiq8MaXFhIDkQNuR1Q7pMFdMfT2jogJ8/7olO7M3EtzxC8EIwfJKhTX
            r15M2h3jbBwplmsNZKOB1GVvrXjOm1KtOZ4CTTM0WrPaLVDT9ax8pykjmFw16vGP
            j/R5Dky9VpabtfZOu/AEW259XDEiQgTrB4Eg+S4GJjHqAzPZBmMy/xhlDK4oMXef
            qXScfD4w0RxuuCFr6lxLPZz0S35BK1kIWmIkuv+9eQuI4Hr1CyVwch4fkfvrp84x
            8tvAFnkCgYEA87NZaG9a8/Mob6GgY4BVLHJVOSzzFdNyMA+4LfSbtzgON2RSZyeD
            0JpDowwXssw5XOyUUctj2cLLdlMCpDfdzk4F/PEakloDJWpason3lmur0/5Oq3T9
            3+fnNUl4d3UOs1jcJ1yGQ/BfrTyRTcEoZx8Mu9mJ4ituVkKuLeG5vX0CgYEA+r/w
            QBJS6kDyQPj1k/SMClUhWhyADwDod03hHTQHc9BleJyjXmVy+/pWhN7aELhjgLbf
            o/Gm3aKJjCxS4qBmqUKwAvGoSVux1Bo2ZjcfF7sX9BXBOlFTG+bPVCZUoaksTyXN
            g7GsA1frKkWWkgQuOeK3o/p9IZoBl93vEgcTGgsCgYEAv5ucCIjFMllUybCCsrkM
            Ps4GQ9YbqmV9ulwhq8BPTlc8lkDCqWhgM3uXAnNXjrUTxQQd+dG4yFZoMrhBs2xZ
            cQPXoXDQO5GaN6jPduETUamGiD/DCvwJQCrNlxAVL5dR36FWN3x/9JriHwsoE8Jz
            SeEX2frIdpM/RYNX/6sipuECgYEA+rwFRDxOdvm8hGWuQ2WMxyQ7Nn07PEV/LxVM
            HkSRkyh23vVakyDEqty3uSOSUJfgv6ud07TnU8ac3fLQatdT8LrDgB4fVkN/fYU8
            kldaGwO1vxgl4OfDQCo7dXzisciViwtVBvQZ+jnm6J0vJBFUHAPt9+WZTIlQQIjm
            71LtseMCgYBSAhs6lshtz+ujR3fmc4QqJVGqeXvEBPAVm6yYoKYRLwVs/rFv3WLN
            LOwwBQ6lz7P9RqYYB5wVlaRvEhb9+lCve/xVcxMeZ5GkOBPxVygYV9l/wNdE25Nz
            OHYtKG3GK3GEcFDwZU2LPHq21EroUAdtRfbrJ4KW2yc8igtXKxTBYw==
            -----END RSA PRIVATE KEY-----
            """;
}
