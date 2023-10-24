import Image from "next/image";
import logo from "@/assets/images/logo.svg";

export default function FormsLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <section className="h-screen w-screen">
      <header className="m-auto h-28 relative">
        <Image
          src={logo}
          priority
          alt="Quizwiz logo"
          className="m-auto w-[127px] h-auto"
        />
        <div className="flex items-center justify-center w-9 h-9 rounded-full bg-primary text-primary-foreground absolute top-2 right-2">
          <span>AV</span>
        </div>
      </header>
      {children}
    </section>
  );
}
