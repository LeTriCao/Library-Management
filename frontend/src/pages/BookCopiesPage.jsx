import { RefreshCcw } from "lucide-react";
import { useEffect, useState } from "react";
import { libraryApi } from "../api/libraryApi";
import DataTable from "../components/DataTable";
import PageHeader from "../components/PageHeader";
import StatusBadge from "../components/StatusBadge";
import { useToast } from "../components/ToastProvider";

export default function BookCopiesPage() {
    const toast = useToast();
    const [data, setData] = useState([]);

    async function load() {
        try {
            setData(await libraryApi.bookCopies());
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
                eyebrow="Inventory"
                title="Quản lý cuốn sách"
                description="Theo dõi từng bản sách vật lý, vị trí, chi nhánh và trạng thái."
                right={<button className="soft-button" onClick={load}><RefreshCcw size={17} /> Tải lại</button>}
            />

            <DataTable
                data={data}
                columns={[
                    { key: "maCuonSach", title: "Mã cuốn" },
                    { key: "maDauSach", title: "Đầu sách" },
                    { key: "maChiNhanh", title: "Chi nhánh" },
                    { key: "maViTri", title: "Vị trí" },
                    { key: "maTrangThai", title: "Trạng thái", render: (r) => <StatusBadge value={r.maTrangThai} /> },
                    { key: "maVach", title: "Mã vạch" }
                ]}
            />
        </div>
    );
}