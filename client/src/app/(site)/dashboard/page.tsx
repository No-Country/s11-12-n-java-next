import DashboardCard from "@/components/dashboard/DashboardCard";
import logo from "@/assets/images/logo.svg";
import Image from "next/image";

export default function Dashboard() {
  return (
    <>
      <div className="flex relative justify-center ">
        <Image src={logo} alt="logo" width={174} height={188} />
        <div className="absolute top-10 right-10 w-12 h-12 bg-teal-700 rounded-full text-center items-center flex flex-col justify-center text-white font-medium">
          V
        </div>
      </div>
      <div className="flex justify-center w-96">
      <div className="w-52 h-8 text-teal-700 text-3xl font-black leading-none text-center flex justify-center">
          Hola Victor!
        </div>
      </div>
      <DashboardCard />
    </>
  );
}
