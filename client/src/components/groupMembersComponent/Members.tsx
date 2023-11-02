import MemberData from "./MemberData";

export default function Members() {

    const mockMemberData = [
        { name: 'Valesca Atenas', email: 'valescaatenas@gmail.com' },
        { name: 'Alan Tello', email: 'alantello@gmail.com' },
        { name: 'Dhessy', email: 'dhessy@gmail.com' },
        { name: 'Eynar Alvarez', email: 'eynaralvarez@gmail.com' },
        { name: 'Andres Frei', email: 'andresfrei@gmail.com' },
        { name: 'David', email: 'david@gmail.com' },
    ]

    return (
        <>
            <p className="text-teal-700 text-xl font-black text-center leading-4">
                No Country Cohorte s11-11-12 A
            </p>
            {
                mockMemberData.map((memberData) => (
                    <MemberData key={memberData.email} name={memberData.name} email={memberData.email} />
                ))
            }
        </>
    )
}
