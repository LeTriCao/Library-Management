import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

export default function ProtectedRoute({ children }) {
    const { user, loadingUser } = useAuth();

    if (loadingUser) {
        return <div style={{ padding: 24 }}>Đang kiểm tra đăng nhập...</div>;
    }

    if (!user) {
        return <Navigate to="/login" replace />;
    }

    return children;
}