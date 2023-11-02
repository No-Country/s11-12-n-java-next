import Image from "next/image";
import logo from "@/assets/images/logo.svg";
import Avatar from "@/components/avatar/Avatar";
import BackButton from "@/components/backButton/BackButton";

export default function FormsLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <section className="h-[100dvh] w-[100dvw] p-4">
      <header className="flex h-28 relative">
        <div>
          <BackButton />
          <Avatar />
        </div>
        <Image
          src={logo}
          priority
          alt="Quizwiz logo"
          className="m-auto w-[127px] h-auto"
        />
      </header>
      {children}
    </section>
  );
}
