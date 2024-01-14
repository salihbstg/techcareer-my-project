const Turkish = () => {
  return (
    <div className="question-form w-full h-[85%] flex">
      <form
        action=""
        className="w-[50%] h-[75%] text-center justify-center flex flex-col mx-auto"
      >
        <label className="border-b border-black">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Itaque alias
          sit laudantium aperiam ex ad!
        </label>
        <label>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Numquam vel
          sapiente dolor veniam voluptatem cupiditate dolorum aperiam, animi rem
          facilis!
        </label>
        <div className="question-button border-t py-10 bg-gray-400 border-black flex flex-col mt-10 items-start gap-2">
          <div className="flex w-full gap-1 ps-6 items-center">
            <button className="p-3">A)</button>
            <p>Soru 1 buraya</p>
          </div>
          <div className="flex w-full gap-1 ps-6 items-center">
            <button className="p-3">B)</button>
            <p>Soru 1 buraya</p>
          </div>
          <div className="flex w-full gap-1 ps-6 items-center">
            <button className="p-3">C)</button>
            <p>Soru 1 buraya</p>
          </div>
          <div className="flex w-full gap-1 ps-6 items-center">
            <button className="p-3">D)</button>
            <p>Soru 1 buraya</p>
          </div>
          <div className="flex w-full gap-1 ps-6 items-center">
            <button className="p-3">E)</button>
            <p>Soru 1 buraya</p>
          </div>
        </div>
        <button className="text-white py-1 my-1 bg-black">Sonraki soru</button>
      </form>
    </div>
  );
};

export default Turkish;
