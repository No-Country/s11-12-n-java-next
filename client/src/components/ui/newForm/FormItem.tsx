import { Input } from "@nextui-org/react";

export default function FormItem ({ subject }: { subject: string }) {
  return (
    <div className="mt-6 flex flex-col gap-2">
      <label className="text-primary font-medium">{subject}</label>
      <Input className="border-2 border-primary-400 rounded-2xl" type="text" />  
    </div>
  )
}