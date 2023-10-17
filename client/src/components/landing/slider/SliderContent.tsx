import Image from "next/image";
import { sliderLandingData } from "@/utils/constants";

interface Props {
  currentSlider: number;
}

const SliderContent = ({ currentSlider }: Props) => {
  const data = sliderLandingData;
  
  return (
    <div className="h-full flex flex-col items-center justify-evenly">
      {data.map((slide, index) => (
        <div
          key={slide.id}
          className={`h-full flex flex-col items-center justify-evenly ${
            currentSlider !== index ? "hidden" : ""
          }`}
        >
          <Image src={slide.image.src} alt={slide.image.alt} />
          <p className="text-center">{slide.text}</p>
        </div>
      ))}
    </div>
  );
};
export default SliderContent;
