import Image from 'next/image'
import Link from 'next/link'
import GroupsData from './GroupsData'

export default function Groups() {
    const mockGroupData = [
        { name: 'No Country Cohorte s11-12 (A)', quantity: 12 },
        { name: 'No Country Cohorte s11-12 (B)', quantity: 7 },
        { name: 'No Country Cohorte s11-12 (B)', quantity: 10 },
    ]
    return (
        <>
            <div className='flex flex-col items-center'>
                <p className="text-teal-700 text-xl font-light text-center">
                    Hemos añadido los siguientes
                </p>
                <span className="text-teal-700 text-2xl font-black uppercase">grupos</span>
            </div>
            <div className='flex flex-col gap-6 mx-auto'>
                {
                    mockGroupData.map(group => (
                        <GroupsData key={group.name} name={group.name} quantity={group.quantity} />
                    ))
                }
            </div>
        </>
    )
}
