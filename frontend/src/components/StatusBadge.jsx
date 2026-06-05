export default function StatusBadge({ value }) {
    const text = value || "Không rõ";

    const type =
        text.includes("Sẵn") || text.includes("Hoạt động") || text.includes("Thành công") || text.includes("Đã")
            ? "good"
            : text.includes("mượn") || text.includes("Đang") || text.includes("một phần")
                ? "warn"
                : text.includes("Mất") || text.includes("Hỏng") || text.includes("Khóa")
                    ? "bad"
                    : "neutral";

    return <span className={`status-badge status-${type}`}>{text}</span>;
}