export default function DataTable({ columns, data, emptyText = "Chưa có dữ liệu" }) {
    return (
        <div className="table-card">
            <table className="data-table">
                <thead>
                <tr>
                    {columns.map((column) => (
                        <th key={column.key}>{column.title}</th>
                    ))}
                </tr>
                </thead>

                <tbody>
                {data?.length > 0 ? (
                    data.map((row, index) => (
                        <tr key={row.id || row.maDauSach || row.maCuonSach || row.maDocGia || index}>
                            {columns.map((column) => (
                                <td key={column.key}>
                                    {column.render ? column.render(row) : row[column.key]}
                                </td>
                            ))}
                        </tr>
                    ))
                ) : (
                    <tr>
                        <td className="empty-cell" colSpan={columns.length}>
                            {emptyText}
                        </td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    );
}