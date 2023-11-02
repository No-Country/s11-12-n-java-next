import Link from "next/link";

interface MemberDataProps {
    name: string;
    email: string;
}

export default function MemberData({ name, email }: MemberDataProps) {
    return (
        <Link href='/' className="flex flex-col justify-center border-3 rounded-[29px] border-blue-400 w-[358px] max-h-[99px] p-5">
            <p className="text-teal-700 font-black text-xl">{name}</p>
            <p className="text-teal-700 font-light text-xl">{email}</p>
        </Link>
    )
}
