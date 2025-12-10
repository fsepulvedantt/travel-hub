(function() {
    'use strict';
    
    var carousel = document.getElementById('carouselTravelHub');
    if (!carousel) return;

    var carouselInner = carousel.querySelector('.carousel-inner');
    var items = carousel.querySelectorAll('.carousel-item');
    var indicators = carousel.querySelectorAll('.carousel-indicators li');
    var prevBtn = carousel.querySelector('.carousel-control-prev');
    var nextBtn = carousel.querySelector('.carousel-control-next');

    var currentIndex = 0;
    var totalItems = items.length;
    var autoplayInterval = null;
    var isDragging = false;
    var startX = 0;
    var currentX = 0;
    var startTime = 0;
    var threshold = 50;

    // Función para mostrar un slide específico
    function showSlide(index) {
        // Asegurar que el índice sea cíclico
        if (index >= totalItems) {
            index = 0;
        } else if (index < 0) {
            index = totalItems - 1;
        }

        // Remover active de todos
        items.forEach(function(item) {
            item.classList.remove('active');
        });
        indicators.forEach(function(indicator) {
            indicator.classList.remove('active');
        });

        // Agregar active al actual
        items[index].classList.add('active');
        if (indicators[index]) {
            indicators[index].classList.add('active');
        }

        currentIndex = index;
    }

    // Ir al siguiente slide
    function nextSlide() {
        showSlide(currentIndex + 1);
    }

    // Ir al slide anterior
    function prevSlide() {
        showSlide(currentIndex - 1);
    }

    // Event listeners para los botones
    if (nextBtn) {
        nextBtn.addEventListener('click', function(e) {
            e.preventDefault();
            nextSlide();
            resetAutoplay();
        });
    }

    if (prevBtn) {
        prevBtn.addEventListener('click', function(e) {
            e.preventDefault();
            prevSlide();
            resetAutoplay();
        });
    }

    // Event listeners para los indicadores
    indicators.forEach(function(indicator, index) {
        indicator.addEventListener('click', function(e) {
            e.preventDefault();
            showSlide(index);
            resetAutoplay();
        });
    });

    // Funcionalidad de arrastre/swipe
    carouselInner.addEventListener('mousedown', dragStart);
    carouselInner.addEventListener('mousemove', drag);
    carouselInner.addEventListener('mouseup', dragEnd);
    carouselInner.addEventListener('mouseleave', dragEnd);

    carouselInner.addEventListener('touchstart', dragStart, { passive: true });
    carouselInner.addEventListener('touchmove', drag, { passive: false });
    carouselInner.addEventListener('touchend', dragEnd);

    function dragStart(e) {
        isDragging = true;
        startTime = Date.now();
        startX = getPositionX(e);
        stopAutoplay();
    }

    function drag(e) {
        if (!isDragging) return;
        e.preventDefault();
        currentX = getPositionX(e);
    }

    function dragEnd(e) {
        if (!isDragging) return;

        isDragging = false;
        var diffX = currentX - startX;
        var diffTime = Date.now() - startTime;

        // Determinar si fue un swipe válido
        if (Math.abs(diffX) > threshold || (Math.abs(diffX) > 20 && diffTime < 300)) {
            if (diffX > 0) {
                prevSlide();
            } else {
                nextSlide();
            }
        }

        startAutoplay();
    }

    function getPositionX(e) {
        return e.type.includes('mouse') ? e.pageX : e.touches[0].clientX;
    }

    // Prevenir arrastre de imágenes
    carouselInner.querySelectorAll('img').forEach(function(img) {
        img.addEventListener('dragstart', function(e) {
            e.preventDefault();
        });
    });

    // Autoplay
    function startAutoplay() {
        stopAutoplay();
        autoplayInterval = setInterval(nextSlide, 5000);
    }

    function stopAutoplay() {
        if (autoplayInterval) {
            clearInterval(autoplayInterval);
            autoplayInterval = null;
        }
    }

    function resetAutoplay() {
        stopAutoplay();
        startAutoplay();
    }

    // Pausar autoplay al pasar el mouse
    carousel.addEventListener('mouseenter', stopAutoplay);
    carousel.addEventListener('mouseleave', startAutoplay);

    // Navegación con teclado
    document.addEventListener('keydown', function(e) {
        if (e.key === 'ArrowLeft') {
            prevSlide();
            resetAutoplay();
        } else if (e.key === 'ArrowRight') {
            nextSlide();
            resetAutoplay();
        }
    });

    // Inicializar autoplay
    startAutoplay();

})();