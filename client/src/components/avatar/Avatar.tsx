"use client";
import useSession from "@/hooks/useSession";
import {
  Dropdown,
  DropdownTrigger,
  DropdownMenu,
  DropdownItem,
} from "@nextui-org/react";
import useStore from "@/hooks/useStore";
import { useSessionStore } from "@/store/sessionStore";

function Avatar() {
  const session = useStore(useSessionStore, (state) => state.session);
  const { handleLogout } = useSession();

  const names = session?.fullname.split(" ");
  const initials = names && `${names[0][0]}${names[names.length - 1][0]}`;

  return (
    <>
      <Dropdown placement="bottom-end">
        <DropdownTrigger>
          <div className="flex items-center justify-center w-10 h-10 rounded-full bg-primary text-primary-foreground absolute top-0 right-0 cursor-pointer">
            <span className="font-bold">{initials}</span>
          </div>
        </DropdownTrigger>
        <DropdownMenu aria-label="Profile Actions" variant="flat">
          <DropdownItem
            textValue="User email"
            key="profile"
            className="h-14 gap-2"
          >
            <p className="font-semibold">{session?.email}</p>
          </DropdownItem>
          <DropdownItem
            textValue="Cerrar Sesión"
            key="logout"
            color="danger"
            onClick={handleLogout}
          >
            Cerrar Sesión
          </DropdownItem>
        </DropdownMenu>
      </Dropdown>
    </>
  );
}
export default Avatar;
