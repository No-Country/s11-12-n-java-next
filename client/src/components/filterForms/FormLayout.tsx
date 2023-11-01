export default function FormLayout({ children }: { children: React.ReactNode}) {
  return (
    <section className="flex flex-col mx-auto gap-4 w-80 pb-8">
      {children}
    </section>
  )
}