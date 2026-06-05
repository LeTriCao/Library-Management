import { useState } from "react";
import { Bar, BarChart, CartesianGrid, ResponsiveContainer, Tooltip, XAxis, YAxis } from "recharts";
import { libraryApi } from "../api/libraryApi";
import DataTable from "../components/DataTable";
import PageHeader from "../components/PageHeader";
import { useToast } from "../components/ToastProvider";

export default function ReportsPage() {
    const toast = useToast();
    const now = new Date();

    const [month, setMonth] = useState(now.getMonth() + 1);
    const [year, setYear] = useState(now.getFullYear());
    const [borrow, setBorrow] = useState([]);
    const [late, setLate] = useState([]);

    async function load() {
        try {
            const [borrowData, lateData] = await Promise.all([
                libraryApi.borrowByCategoryReport(month, year),
                libraryApi.lateReturnsReport(month, year)
            ]);

            setBorrow(Array.isArray(borrowData) ? borrowData : []);
            setLate(Array.isArray(lateData) ? lateData : []);
            toast.success("Đã tải báo cáo");
        } catch (err) {
            toast.error(err.message);
        }
    }

    const chartData = borrow.map((item) => ({
        name: item.tenTheLoai || item.maTheLoai,
        value: Number(item.soLuotMuon || 0)
    }));

    return (
        <div>
            <PageHeader
                eyebrow="Reports"
                title="Báo cáo thư viện"
                description="Thống kê mượn sách theo thể loại và danh sách trả trễ trong tháng."
            />

            <div className="panel compact-form">
                <label>Tháng</label>
                <input type="number" min="1" max="12" value={month} onChange={(e) => setMonth(e.target.value)} />

                <label>Năm</label>
                <input type="number" value={year} onChange={(e) => setYear(e.target.value)} />

                <button className="primary-button" onClick={load}>Xem báo cáo</button>
            </div>

            <div className="grid-2">
                <div className="panel">
                    <div className="panel-title">
                        <h2>Mượn theo thể loại</h2>
                    </div>

                    <div className="chart-box">
                        <ResponsiveContainer width="100%" height={280}>
                            <BarChart data={chartData}>
                                <CartesianGrid strokeDasharray="3 3" vertical={false} />
                                <XAxis dataKey="name" />
                                <YAxis allowDecimals={false} />
                                <Tooltip />
                                <Bar dataKey="value" radius={[8, 8, 0, 0]} />
                            </BarChart>
                        </ResponsiveContainer>
                    </div>
                </div>

                <div className="panel">
                    <div className="panel-title">
                        <h2>Sách trả trễ</h2>
                    </div>

                    <DataTable
                        data={late}
                        columns={[
                            { key: "maCuonSach", title: "Mã cuốn" },
                            { key: "tenDauSach", title: "Tên sách" },
                            { key: "hoTenDocGia", title: "Độc giả" },
                            { key: "soNgayTre", title: "Ngày trễ" },
                            { key: "tienPhatTre", title: "Tiền phạt", render: (r) => `${Number(r.tienPhatTre || 0).toLocaleString()}đ` }
                        ]}
                    />
                </div>
            </div>
        </div>
    );
}