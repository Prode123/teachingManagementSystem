(function () {
  function initFontSize() {
    let scale = window.innerWidth / 1920;
    scale = scale < 0.5 ? 0.5 : scale;
    document.documentElement.style.fontSize = scale * 24 + 'px';
  }
  initFontSize();
  window.addEventListener('resize', initFontSize);
})();
