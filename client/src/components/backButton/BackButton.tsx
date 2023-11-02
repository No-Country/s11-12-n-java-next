"use client";
import { usePathname, useRouter } from "next/navigation";

const BackButton = () => {
  const router = useRouter();
  const pathname = usePathname();

  const isNotDashboard = pathname !== "/dashboard";

  const handleVolverAtras = () => {
    router.back();
  };

  if (isNotDashboard) {
    return <button onClick={handleVolverAtras}>Atrás</button>;
  }

  return null;
};
export default BackButton;
