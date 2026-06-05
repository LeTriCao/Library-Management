import { RefreshCcw } from "lucide-react";
import { useEffect, useState } from "react";
import { libraryApi } from "../api/libraryApi";
import DataTable from "../components/DataTable";
import PageHeader from "../components/PageHeader";
import StatusBadge from "../components/StatusBadge";
import { useToast } from "../components/ToastProvider";

export default function BooksPage() {
    const toast = useToast();
    const [data, setData] = useState([]);

    async function load() {
        try {
            setData(await libraryApi.books());
        } catch (err) {
            toast.error(err.message);
        }
    }

    useEffect(() => {
        load();
    }, []);

    return (
        <div>
            <PageHeader
                eyebrow="Catalog"
                title="Quản lý đầu sách"
                description="Danh sách đầu sách, ISBN, trị giá và trạng thái hiển thị."
                right={<button className="soft-button" onClick={load}><RefreshCcw size={17} /> Tải lại</button>}
            />

            <DataTable
                data={data}
                columns={[
                    { key: "maDauSach", title: "Mã" },
                    { key: "tenDauSach", title: "Tên đầu sách" },
                    { key: "isbn", title: "ISBN" },
                    { key: "namXuatBan", title: "Năm XB" },
                    { key: "triGia", title: "Trị giá", render: (r) => `${Number(r.triGia || 0).toLocaleString()}đ` },
                    { key: "trangThai", title: "Trạng thái", render: (r) => <StatusBadge value={r.trangThai} /> }
                ]}
            />
        </div>
    );
}