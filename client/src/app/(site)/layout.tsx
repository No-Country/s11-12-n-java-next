import Image from "next/image";
import logo from "@/assets/images/logo.svg";
import Avatar from "@/components/avatar/Avatar";

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
        <Avatar />
      </header>
      {children}
    </section>
  );
}
