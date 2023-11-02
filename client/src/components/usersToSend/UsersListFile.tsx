import mainImage from '@/assets/images/sammy-line-girl-updates-the-system-settings-of-the-computer 1.svg'
import Image from 'next/image'
import Button from '../ui/button/Button'
export default function UsersListFile() {
    return (
        <>
            <p className="text-teal-700 text-2xl font-light max-w-[302px]">A quién le enviarás este <span className="font-black uppercase">cuestionario?</span></p>
            <Image src={mainImage} alt="mainImage" width={304} height={304} />
            <Button
                title='Subir archivo'
                size='md'
                className='w-full mt-[-18px]'
            >Subir archivo</Button>
        </>
    )
}
