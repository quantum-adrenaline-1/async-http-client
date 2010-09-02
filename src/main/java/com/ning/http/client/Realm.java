/*
 * Copyright 2010 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */
package com.ning.http.client;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Realm {


    private final static Charset UTF_8 = Charset.forName("UTF-8");
    private final static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static final String NC = "00000001";

    private final String principal;
    private final String password;
    private final AuthScheme scheme;
    private final String realmName;
    private final String nonce;
    private final String algorithm;
    private final String response;
    private final String qop;
    private final String nc;
    private final String cnonce;
    private final String uri;
    private final String methodName;

    private final static Pattern REALM = Pattern.compile("REALM=");

    public enum AuthScheme {
        DIGEST,
        BASIC
    }

    private Realm(AuthScheme scheme,
                  String principal,
                  String password,
                  String realmName,
                  String nonce,
                  String algorithm,
                  String response,
                  String qop,
                  String nc,
                  String cnonce,
                  String uri, String method) {

        this.principal = principal;
        this.password = password;
        this.scheme = scheme;
        this.realmName = realmName;
        this.nonce = nonce;
        this.algorithm = algorithm;
        this.response = response;
        this.qop = qop;
        this.nc = nc;
        this.cnonce = cnonce;
        this.uri = uri;
        this.methodName = method;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getPassword() {
        return password;
    }

    public AuthScheme getAuthScheme() {
        return scheme;
    }

    public AuthScheme getScheme() {

        return scheme;
    }

    public String getRealmName() {
        return realmName;
    }

    public String getNonce() {
        return nonce;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getResponse() {
        return response;
    }

    public String getQop() {
        return qop;
    }

    public String getNc() {
        return nc;
    }

    public String getCnonce() {
        return cnonce;
    }

    public String getUri() {
        return uri;
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Realm realm = (Realm) o;

        if (algorithm != null ? !algorithm.equals(realm.algorithm) : realm.algorithm != null) return false;
        if (cnonce != null ? !cnonce.equals(realm.cnonce) : realm.cnonce != null) return false;
        if (nc != null ? !nc.equals(realm.nc) : realm.nc != null) return false;
        if (nonce != null ? !nonce.equals(realm.nonce) : realm.nonce != null) return false;
        if (password != null ? !password.equals(realm.password) : realm.password != null) return false;
        if (principal != null ? !principal.equals(realm.principal) : realm.principal != null) return false;
        if (qop != null ? !qop.equals(realm.qop) : realm.qop != null) return false;
        if (realmName != null ? !realmName.equals(realm.realmName) : realm.realmName != null) return false;
        if (response != null ? !response.equals(realm.response) : realm.response != null) return false;
        if (scheme != realm.scheme) return false;
        if (uri != null ? !uri.equals(realm.uri) : realm.uri != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Realm{" +
                "principal='" + principal + '\'' +
                ", password='" + password + '\'' +
                ", scheme=" + scheme +
                ", realmName='" + realmName + '\'' +
                ", nonce='" + nonce + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", response='" + response + '\'' +
                ", qop='" + qop + '\'' +
                ", nc='" + nc + '\'' +
                ", cnonce='" + cnonce + '\'' +
                ", uri='" + uri + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = principal != null ? principal.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (scheme != null ? scheme.hashCode() : 0);
        result = 31 * result + (realmName != null ? realmName.hashCode() : 0);
        result = 31 * result + (nonce != null ? nonce.hashCode() : 0);
        result = 31 * result + (algorithm != null ? algorithm.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (qop != null ? qop.hashCode() : 0);
        result = 31 * result + (nc != null ? nc.hashCode() : 0);
        result = 31 * result + (cnonce != null ? cnonce.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }

    public static class RealmBuilder {

        private String principal = "";
        private String password = "";
        private AuthScheme scheme = AuthScheme.BASIC;
        private String realmName = "";
        private String nonce = "";
        private String algorithm = "MD5";
        private String response = "";
        private String qop = "auth";
        private String nc = "00000001";
        private String cnonce = "";
        private String uri = "";
        private String methodName = "GET";

        public String getPrincipal() {
            return principal;
        }

        public RealmBuilder setPrincipal(String principal) {
            this.principal = principal;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public RealmBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AuthScheme getScheme() {
            return scheme;
        }

        public RealmBuilder setScheme(AuthScheme scheme) {
            this.scheme = scheme;
            return this;
        }

        public String getRealmName() {
            return realmName;
        }

        public RealmBuilder setRealmName(String realmName) {
            this.realmName = realmName;
            return this;
        }

        public String getNonce() {
            return nonce;
        }

        public RealmBuilder setNonce(String nonce) {
            this.nonce = nonce;
            return this;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public RealmBuilder setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public String getResponse() {
            return response;
        }

        public RealmBuilder setResponse(String response) {
            this.response = response;
            return this;
        }

        public String getQop() {
            return qop;
        }

        public RealmBuilder setQop(String qop) {
            this.qop = qop;
            return this;
        }

        public String getNc() {
            return nc;
        }

        public RealmBuilder setNc(String nc) {
            this.nc = nc;
            return this;
        }

        public String getUri() {
            return uri;
        }

        public RealmBuilder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public String getMethodName() {
            return methodName;
        }

        public RealmBuilder setMethodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public RealmBuilder parseWWWAuthenticateHeader(String headerLine) {
            setRealmName(match(headerLine, "realm"));
            setNonce(match(headerLine, "nonce"));
            setAlgorithm(match(headerLine, "algorithm"));
            setQop(match(headerLine, "qop"));
            return this;
        }

        private String match(String headerLine, String token) {
            int match = headerLine.indexOf(token);
            if (match <= 0) return "";

            // = to skip
            match += token.length() + 1;
            int traillingComa = headerLine.indexOf(",", match);
            String value = headerLine.substring(match, traillingComa > 0 ? traillingComa : headerLine.length());
            value = value.endsWith("\"") ? value.substring(0, value.length() - 1) : value;
            return value.startsWith("\"") ? value.substring(1) : value;
        }

        public RealmBuilder clone(Realm clone) {
            setRealmName(clone.getRealmName());
            setAlgorithm(clone.getAlgorithm());
            setMethodName(clone.getMethodName());
            setNc(clone.getNc());
            setNonce(clone.getNonce());
            setPassword(clone.getPassword());
            setPrincipal(clone.getPrincipal());
            setQop(clone.getQop());
            setScheme(clone.getScheme());
            setUri(clone.getUri());
            return this;
        }

        private void newCnonce() {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] b = md.digest(String.valueOf(System.currentTimeMillis()).getBytes(ISO_8859_1));
                cnonce = encode(b);
            } catch (Exception e) {
                 throw new SecurityException(e);
            }
        }

        protected void newResponse() {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new SecurityException(e);
            }
            md.update(principal.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(realmName.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(password.getBytes(ISO_8859_1));
            byte[] ha1 = md.digest();
            md.reset();
            md.update(methodName.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(uri.getBytes(ISO_8859_1));
            byte[] ha2 = md.digest();

            md.update(convert(ha1, 16).getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(nonce.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(NC.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(cnonce.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(qop.getBytes(ISO_8859_1));
            md.update((byte) ':');
            md.update(convert(ha2, 16).getBytes(ISO_8859_1));
            byte[] digest = md.digest();

            response = encode(digest);
        }

        private static String encode(byte[] data) {
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                buffer.append(Integer.toHexString((data[i] & 0xf0) >>> 4));
                buffer.append(Integer.toHexString(data[i] & 0x0f));
            }
            return buffer.toString();
        }

        private static String convert(byte[] bytes, int base) {
            StringBuilder buf = new StringBuilder();
            for (byte b : bytes) {
                int bi = 0xff & b;
                int c = '0' + (bi / base) % base;
                if (c > '9')
                    c = 'a' + (c - '0' - 10);
                buf.append((char) c);
                c = '0' + bi % base;
                if (c > '9')
                    c = 'a' + (c - '0' - 10);
                buf.append((char) c);
            }
            return buf.toString();
        }

        public Realm build() {

            if (nonce != null && !nonce.equals("")) {
                newCnonce();
                newResponse();
            }

            return new Realm(scheme,
                    principal,
                    password,
                    realmName,
                    nonce,
                    algorithm,
                    response,
                    qop,
                    nc,
                    cnonce,
                    uri,
                    methodName);
        }
    }

}
