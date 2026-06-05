import { createContext, useContext, useEffect, useState } from "react";
import { getToken } from "../api/apiClient";
import { loginApi, logoutApi, meApi } from "../api/authApi";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
    const [user, setUser] = useState(null);
    const [loadingUser, setLoadingUser] = useState(true);

    useEffect(() => {
        async function loadUser() {
            try {
                if (!getToken()) {
                    setUser(null);
                    return;
                }

                const data = await meApi();
                setUser(data);
            } catch {
                setUser(null);
            } finally {
                setLoadingUser(false);
            }
        }

        loadUser();
    }, []);

    async function login(usernameOrEmail, password) {
        const data = await loginApi(usernameOrEmail, password);
        setUser(data);
        return data;
    }

    function logout() {
        logoutApi();
        setUser(null);
    }

    return (
        <AuthContext.Provider value={{ user, loadingUser, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth() {
    return useContext(AuthContext);
}