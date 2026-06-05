import { RefreshCcw } from "lucide-react";
import { useEffect, useState } from "react";
import { libraryApi } from "../api/libraryApi";
import DataTable from "../components/DataTable";
import PageHeader from "../components/PageHeader";
import StatusBadge from "../components/StatusBadge";
import { useToast } from "../components/ToastProvider";

export default function ReadersPage() {
    const toast = useToast();
    const [data, setData] = useState([]);

    async function load() {
        try {
            setData(await libraryApi.readers());
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
                eyebrow="Members"
                title="Quản lý độc giả"
                description="Thông tin độc giả, email, số điện thoại, hạn thẻ và trạng thái."
                right={<button className="soft-button" onClick={load}><RefreshCcw size={17} /> Tải lại</button>}
            />

            <DataTable
                data={data}
                columns={[
                    { key: "maDocGia", title: "Mã ĐG" },
                    { key: "hoTen", title: "Họ tên" },
                    { key: "email", title: "Email" },
                    { key: "soDienThoai", title: "SĐT" },
                    { key: "ngayHetHanThe", title: "Hạn thẻ" },
                    { key: "trangThai", title: "Trạng thái", render: (r) => <StatusBadge value={r.trangThai} /> }
                ]}
            />
        </div>
    );
}