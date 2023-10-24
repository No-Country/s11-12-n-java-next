import Image from "next/image";
import logo from "@/assets/images/logo.svg";

export default function FormsLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <section className="h-[100dvh] w-[100dvw] p-4">
      <header className="m-auto h-28 relative">
        <Image
          src={logo}
          priority
          alt="Quizwiz logo"
          className="m-auto w-[127px] h-auto"
        />
        <div className="flex items-center justify-center w-10 h-10 rounded-full bg-primary text-primary-foreground absolute top-0 right-0">
          <span>AV</span>
        </div>
      </header>
      {children}
    </section>
  );
}
