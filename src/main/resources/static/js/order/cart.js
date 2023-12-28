document.addEventListener('DOMContentLoaded', function () {
    console.log('Checkbox state changed');

    var checkboxes = document.querySelectorAll('.menuList input[type="checkbox"]');
    var rightMenuContainer = document.getElementById('rightmenus');
    var totalPriceElement = document.querySelector('.sumAmount');

    // 웹페이지 로드 시 rightmenus 비우기
    rightMenuContainer.innerHTML = '';

    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener('change', function () {
            var menuContainer = checkbox.closest('.menuList');
            var name = menuContainer.querySelector('span:nth-child(2)').textContent;

            // 체크 해제 시 해당 메뉴의 rightmenu 제거
            if (!checkbox.checked) {
                removeRightMenu(name);
            } else {
                // 체크 시 rightmenu 추가
                addRightMenu(name);
            }

            updateRightMenu();
        });
    });

    function addRightMenu(name) {
        // 기존에 rightmenu가 없을 때만 추가
        if (!rightMenuContainer.querySelector(`.rightmenu[data-menu-name="${name}"]`)) {
            var rightMenuDiv = document.createElement('div');
            rightMenuDiv.classList.add('rightmenu');
            rightMenuDiv.setAttribute('data-menu-name', name);
            rightMenuDiv.innerHTML = `
        <div>${name}</div>
        <div>수량: <input type="number" min="1" value="1" data-menu-name="${name}" class="quantity-input" /></div>
        <div>가격: 0원</div>
    `;
            rightMenuContainer.appendChild(rightMenuDiv);

            // 수량 입력 요소에 input 이벤트 추가
            var quantityInput = rightMenuDiv.querySelector('.quantity-input');
            quantityInput.addEventListener('input', function () {
                updateRightMenu();
            });
        }
    }

    function removeRightMenu(name) {
        var rightMenuToRemove = rightMenuContainer.querySelector(`.rightmenu[data-menu-name="${name}"]`);
        if (rightMenuToRemove) {
            rightMenuContainer.removeChild(rightMenuToRemove);
        }
    }

    function updateRightMenu() {
        var sum = 0;

        rightMenuContainer.querySelectorAll('.rightmenu').forEach(function (rightMenuDiv) {
            var name = rightMenuDiv.querySelector('div').textContent;
            var quantity = parseInt(rightMenuDiv.querySelector('.quantity-input').value);
            var menuContainer = getMenuContainerByName(name);

            if (menuContainer) {
                var price = parseInt(menuContainer.querySelector('#price').textContent);
                rightMenuDiv.lastElementChild.textContent = `가격: ${price * quantity}원`;
                sum += price * quantity;
            }
        });

        totalPriceElement.textContent = sum;
    }

    function getMenuContainerByName(name) {
        var menuContainers = document.querySelectorAll('.menuList');
        for (var i = 0; i < menuContainers.length; i++) {
            if (menuContainers[i].querySelector('span:nth-child(2)').textContent === name) {
                return menuContainers[i];
            }
        }
        return null;
    }
});