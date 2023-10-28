"use client";
import useSession from "@/hooks/useSession";
function Avatar() {
  const { session } = useSession();
  const names = session.fullname.split(" ");
  const initials = `${names[0][0]}${names[names.length - 1][0]}`;
  return (
    <div className="flex items-center justify-center w-10 h-10 rounded-full bg-primary text-primary-foreground absolute top-0 right-0">
      <span className="font-bold">{initials}</span>
    </div>
  );
}
export default Avatar;
