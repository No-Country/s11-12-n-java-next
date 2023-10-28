import Image from "next/image";
import { sliderLandingData } from "@/utils/constants";

interface Props {
  currentSlider: number;
}

const SliderContent = ({ currentSlider }: Props) => {
  const data = sliderLandingData;

  return (
    <>
      {data.map((slide, index) => (
        <div
          key={slide.id}
          className={`h-full flex flex-col items-center gap-6 animate-appearance-in animation-duration-500 ${
            currentSlider !== index ? "hidden" : ""
          }`}
        >
          <Image src={slide.image.src} alt={slide.image.alt} priority />
          <p
            className={`text-center text-2xl px-4 ${
              currentSlider === 0 ? "font-light" : ""
            }`}
          >
            {slide.text}
          </p>
        </div>
      ))}
    </>
  );
};
export default SliderContent;
