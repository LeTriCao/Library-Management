export default function StatCard({ icon: Icon, label, value, hint }) {
    return (
        <div className="stat-card">
            <div className="stat-icon">
                <Icon size={22} />
            </div>
            <div>
                <div className="stat-label">{label}</div>
                <div className="stat-value">{value}</div>
                {hint && <div className="stat-hint">{hint}</div>}
            </div>
        </div>
    );
}