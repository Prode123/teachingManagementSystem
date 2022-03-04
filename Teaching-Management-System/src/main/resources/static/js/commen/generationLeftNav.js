function generationLeftNav(list) {
  // createTabNac
  const center = document.querySelector('.center');
  function addTabNav(content, i) {
    const items = document.querySelectorAll('.center-item');
    for (let i = 0; i < items.length; i++) {
      let text = items[i].innerText.replace('×', '');
      text = text.replaceAll('\n', '');
      if (text === content) {
        for (j = 0; j < items.length; j++) {
          items[j].classList.remove('active');
        }
        items[i].classList.add('active');

        return;
      }
    }
    const center_item = document.createElement('div');
    center_item.classList = 'center-item';
    center_item.setAttribute('data-to', i);
    center_item.innerHTML = i === 0 ? `${content}` : `${content}<span>×</span>`;
    let _items = document.querySelectorAll('.center-item');
    for (j = 0; j < _items.length; j++) {
      _items[j].classList.remove('active');
    }
    center_item.classList.add('active');
    center_item.addEventListener(
      'click',
      function (e) {
        const items = document.querySelectorAll('.center-item');
        const wrapperRightItems = document.querySelectorAll('.wrapper-right-item');
        const lis = ul.querySelectorAll('li.item');
        // 删除
        if (e.target !== this) {
          if (items.length <= 1) return;
          const nextel = e.target.parentElement.nextElementSibling;
          const preel = e.target.parentElement.previousElementSibling;
          e.target.parentElement.remove(e.target);
          const _itme = document.querySelectorAll('.center-item');
          for (let p = 0; p < _itme.length; p++) {
            _itme[p].classList.remove('active');
          }
          for (let t = 0; t < wrapperRightItems.length; t++) {
            wrapperRightItems[t].classList.remove('show');
          }
          if (nextel) {
            wrapperRightItems[nextel.getAttribute('data-to')].classList.add('show');
            nextel.classList.add('active');
            for (let n = 0; n < lis.length; n++) {
              lis[n].classList.remove('active');
            }
            if (i < 10) {
              lis[nextel.getAttribute('data-to')] &&
                lis[nextel.getAttribute('data-to')].classList.add('active');
            }
          } else {
            wrapperRightItems[preel.getAttribute('data-to')].classList.add('show');
            preel.classList.add('active');
            for (let n = 0; n < lis.length; n++) {
              lis[n].classList.remove('active');
            }
            if (i < 10) {
              lis[preel.getAttribute('data-to')] &&
                lis[preel.getAttribute('data-to')].classList.add('active');
            }
          }
          return;
        }

        for (let j = 0; j < items.length; j++) {
          items[j].classList.remove('active');
        }
        for (let k = 0; k < wrapperRightItems.length; k++) {
          wrapperRightItems[k].classList.remove('show');
        }
        for (let n = 0; n < lis.length; n++) {
          lis[n].classList.remove('active');
        }

        i < 10 ? lis[this.getAttribute('data-to')].classList.add('active') : '';
        wrapperRightItems[this.getAttribute('data-to')].classList.add('show');
        this.classList.add('active');
      },
      true
    );
    center.appendChild(center_item);
  }

  function initNav(navList) {
    const navUl = document.querySelector('.wrapper-nav>ul');
    for (let i = 0; i < navList.length; i++) {
      if (navList[i].type === 1) {
        const cli = document.createElement('li');
        const img = document.createElement('img');
        const cspan = document.createElement('span');
        cspan.classList.add('arrow');
        i === 0 ? cli.classList.add('active') : '';
        i === 0 ? addTabNav(navList[i].title, i) : '';
        cli.classList.add('item');
        img.src = `../../manangmentSystem/img/commen/${navList[i].icon}.png`;
        // img.src = `../../../static/img/commen/${navList[i].icon}.png`;
        img.style.verticalAlign = 'middle';
        img.style.margin = '0 10px 0 0';
        cli.innerText = navList[i].title;
        cli.insertBefore(img, cli.firstChild);
        cli.appendChild(cspan);
        navUl.appendChild(cli);
      }
      if (navList[i].type === 2) {
        // 1.create ul
        const cul = document.createElement('ul');
        // 2.create subli
        if (navList[i].children.length) {
          for (let j = 0; j < navList[i].children.length; j++) {
            const cli = document.createElement('li');
            if (j === 0) {
              const cspan = document.createElement('span');
              const img = document.createElement('img');
              img.src = `../../manangmentSystem//img/commen/${navList[i].children[j].icon}.png`;
              // img.src = `../../../staticimg/commen/${navList[i].children[j].icon}.png`;
              img.style.verticalAlign = 'middle';
              img.style.margin = '0 10px 0 0';
              cli.innerText = navList[i].children[j].title;
              cli.insertBefore(img, cli.firstChild);
              cul.appendChild(cli);
              cspan.classList.add('arrow');
              cli.classList.add('menu');
              cli.appendChild(cspan);
            } else {
              j === 1 && i === 0 ? cli.classList.add('active') : '';
              j === 1 && i === 0 ? addTabNav(navList[i].children[j].title, i) : '';
              cli.classList.add('item');
              cli.innerText = navList[i].children[j].title;
              cul.appendChild(cli);
            }
          }
          navUl.appendChild(cul);
        }
      }
    }
  }

  initNav(list);

  const ul = document.querySelector('.wrapper-nav>ul');
  const lis = ul.querySelectorAll('li.item');
  const wrapperRightItems = document.querySelectorAll('.wrapper-right-item');
  for (let i = 0; i < lis.length; i++) {
    lis[i].addEventListener('click', (e) => {
      const items = document.querySelectorAll('.center-item');
      for (let j = 0; j < wrapperRightItems.length; j++) {
        wrapperRightItems[j].classList.remove('show');
      }
      for (let n = 0; n < lis.length; n++) {
        lis[n].classList.remove('active');
      }
      for (let y = 0; y < items.length; y++) {
        items[y].classList.remove('active');
      }
      addTabNav(lis[i].innerText, i);
      wrapperRightItems[i].classList.add('show');
      lis[i].classList.add('active');
    });
  }

  // subMenuClick
  const menus = document.querySelectorAll('.menu');
  for (let k = 0; k < menus.length; k++) {
    menus[k].setAttribute('data-flag', true);
    menus[k].addEventListener('click', function (e) {
      // reset
      for (let l = 0; l < menus.length; l++) {
        menus[l].parentElement.style.height = `35px`;
        menus[l].children[1].classList.remove('rotate');
      }
      // info
      if (this.getAttribute('data-flag') !== 'false') {
        this.parentElement.style.height = `${this.parentElement.children.length * 35}px`;
        this.children[1].classList.add('rotate');
        // reset
        for (let m = 0; m < menus.length; m++) {
          menus[m].setAttribute('data-flag', true);
        }
        this.setAttribute('data-flag', false);
      } else {
        this.parentElement.style.height = `35px`;
        this.children[1].classList.remove('rotate');
        this.setAttribute('data-flag', true);
      }
    });
  }

  //handelTopRightNavClick
  (function () {
    const lis = document.querySelectorAll('.user-img > ul li');
    const wrapperRightItems = document.querySelectorAll('.wrapper-right-item');
    const rightNavList = document.querySelectorAll('.wrapper-nav>ul li.item');
    for (let i = 1; i < lis.length; i++) {
      lis[i].addEventListener('click', function (e) {
        if (i === lis.length - 1) {
          alert('已退出');
          window.location.href = '../../index.html';
          window.location.href = 'index.html';
          return;
        }
        for (let j = 0; j < wrapperRightItems.length; j++) {
          wrapperRightItems[j].classList.remove('show');
        }
        for (let k = 0; k < rightNavList.length; k++) {
          rightNavList[k].classList.remove('active');
        }
        addTabNav(this.innerText, 10 + i);
        wrapperRightItems[10 + i].classList.add('show');
      });
    }
  })();
}
