import Link from "next/link"
import Image from "next/image"
import groupIcon from '@/assets/icons/PersonsGroup.svg'

interface GroupsData {
    name: string,
    quantity: number
}

export default function GroupsData({ name, quantity }: GroupsData) {
    return (
        <>
            <Link href='/' className='flex justify-between border-3 rounded-[29px] border-blue-400 max-w-[362px] h-[125px] px-6 py-5'>
                <div className='max-w-[200px]'>
                    <p className='text-xl text-teal-700 font-black'>{name}</p>
                </div>
                <div className='flex flex-col items-center justify-center'>
                    <Image src={groupIcon} alt='Persons group icon' height={45} width={49} />
                    <span className='text-teal-700 text-xl font-black leading-4'>{quantity}</span>
                    <span className='text-teal-700 text-xs font-light leading-4'>Personas</span>
                </div>
            </Link>
        </>
    )
}