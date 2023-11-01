import { Input } from "@nextui-org/react";
import { Dispatch, SetStateAction } from "react";

export default function FormItem ({ subject, text, setText }: { subject: string, text: string, setText: Dispatch<SetStateAction<string>> }) {
  return (
    <div className="mt-6 flex flex-col gap-2">
      <label className="text-primary font-medium">{subject}</label>
      <Input value={text} onChange={(e) => setText(e.target.value)} required className="border-2 border-primary-400 rounded-2xl" type="text" />  
    </div>
  )
}