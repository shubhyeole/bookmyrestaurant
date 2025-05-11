$(document).ready(function () {
	// Load Services
	$.ajax({
		url: 'servicesforhomelinktest',
		method: 'GET',
		dataType: 'json',
		success: function (data) {
			const container = $('#services-con');
			container.empty();

			$.each(data, function (i, service) {
				console.log("Name:", service.name);

				const card = `
					<div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.${i + 1}s">
						<div class="service-item rounded pt-3">
							<div class="p-4">
								<i class="${service.icon} fa-3x text-primary mb-4"></i>
								<h5>${service.name}</h5>
								<p>${service.desc}</p>
							</div>
						</div>
					</div>
				`;

				container.append(card);
			});
		},
		error: function () {
			alert('Failed to load service data.');
		}
	});

	// Load Meals
	$.ajax({
		url: 'fetchmeals',
		method: 'GET',
		dataType: 'json',
		success: function (data) {
			const Breakfast = $('#item-con-b');
			const Lunch = $('#item-con-l');
			const Dinner = $('#item-con-d');

			Breakfast.empty();
			Lunch.empty();
			Dinner.empty();

			$.each(data, function (i, item) {
				let card = `
					<div class="col-lg-6">
						<div class="d-flex align-items-center">
							<img class="flex-shrink-0 img-fluid rounded" src="${item.itemImg}" alt="" style="width: 80px; height: 80px; object-fit: cover;">
							<div class="w-100 d-flex flex-column text-start ps-4">
								<h5 class="d-flex justify-content-between border-bottom pb-2">
									<span>${item.itemName}</span> <span class="text-primary">&#8377; ${item.itemPrice}</span>
								</h5>
								<small class="fst-italic">${item.itemDesc}</small>
							</div>
						</div>
					</div>
				`;

				switch (item.itemMeals) {
					case "Breakfast":
						Breakfast.append(card);
						break;
					case "Lunch":
						Lunch.append(card);
						break;
					case "Dinner":
						Dinner.append(card);
						break;
				}
			});
		},
		error: function () {
			alert('Failed to load meal data.');
		}
	});
});


/*
OPTIMIZE CODE	
$(document).ready(function () {
	// Utility to render a service card
	function createServiceCard(service, delay) {
		return `
			<div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.${delay}s">
				<div class="service-item rounded pt-3">
					<div class="p-4">
						<i class="${service.icon} fa-3x text-primary mb-4"></i>
						<h5>${service.name}</h5>
						<p>${service.desc}</p>
					</div>
				</div>
			</div>
		`;
	}

	// Utility to render a meal card
	function createMealCard(item) {
		return `
			<div class="col-lg-6">
				<div class="d-flex align-items-center">
					<img class="flex-shrink-0 img-fluid rounded" src="${item.itemImg}" alt="" style="width: 80px; height: 80px; object-fit: cover;">
					<div class="w-100 d-flex flex-column text-start ps-4">
						<h5 class="d-flex justify-content-between border-bottom pb-2">
							<span>${item.itemName}</span>
							<span class="text-primary">&#8377; ${item.itemPrice}</span>
						</h5>
						<small class="fst-italic">${item.itemDesc}</small>
					</div>
				</div>
			</div>
		`;
	}

	// Load Services
	$.ajax({
		url: 'servicesforhomelinktest',
		method: 'GET',
		dataType: 'json',
		success: function (data) {
			const $container = $('#services-con').empty();

			data.forEach((service, index) => {
				console.log("Name:", service.name);
				$container.append(createServiceCard(service, index + 1));
			});
		},
		error: function () {
			alert('Failed to load service data.');
		}
	});

	// Load Meals
	$.ajax({
		url: 'fetchmeals',
		method: 'GET',
		dataType: 'json',
		success: function (data) {
			const mealMap = {
				Breakfast: $('#item-con-b').empty(),
				Lunch: $('#item-con-l').empty(),
				Dinner: $('#item-con-d').empty()
			};

			data.forEach(item => {
				const $container = mealMap[item.itemMeals];
				if ($container) {
					$container.append(createMealCard(item));
				}
			});
		},
		error: function () {
			alert('Failed to load meal data.');
		}
	});
});




*/