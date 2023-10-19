'use client';

import { useState } from 'react';
import Button from '@/components/ui/button/Button';
import { useRouter } from 'next/navigation';
import { sliderLandingData } from '@/utils/constants';
import SliderContent from './SliderContent';

const Slider = () => {
  const router = useRouter();

  const [currentSlider, setcurrentSlider] = useState(0);

  const handleSetCurrentSlider = (number: number) => {
    if (number >= sliderLandingData.length) {
      router.push('/welcome');
    } else {
      setcurrentSlider(number);
    }
  };

  return (
    <div className='flex flex-col w-full h-full'>
      <SliderContent currentSlider={currentSlider} />
      <div className='mt-auto mb-14 w-full'>
        <Button
          className='w-full'
          size='xl'
          onClick={() => handleSetCurrentSlider(currentSlider + 1)}
        >
          Siguiente
        </Button>
      </div>
    </div>
  );
};
export default Slider;
