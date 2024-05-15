(function ($) {
	$.Shop = function (element) {
		this.$element = $(element);
		this.init();
	};

	$.Shop.prototype = {
		init: function () {

			this.cartPrefix = "Furniture-"; 
			this.cartName = this.cartPrefix + "cart"; 
			this.shippingRates = this.cartPrefix + "shipping-rates"; 
			this.total = this.cartPrefix + "total"; 
			this.storage = sessionStorage; 


			this.$formAddToCart = this.$element.find("form.add-to-cart"); 
			this.$formCart = this.$element.find("#shopping-cart"); 
			this.$checkoutCart = this.$element.find("#checkout-cart");
			this.$checkoutOrderForm = this.$element.find("#checkout-order-form"); 
			this.$shipping = this.$element.find("#sshipping"); 
			this.$subTotal = this.$element.find("#stotal"); 
			this.$shoppingCartActions = this.$element.find("#shopping-cart-actions");  
			this.$emptyCartBtn = this.$shoppingCartActions.find("#empty-cart"); 
			this.$userDetails = this.$element.find("#user-details-content"); 



			this.currency = "&#8377;"; 
			this.currencyString = "₹"; 


			
			this.requiredFields = {
				expression: {
					value: /^([\w-\.]+)@((?:[\w]+\.)+)([a-z]){2,4}$/
				},

				str: {
					value: ""
				}

			};

			

			this.createCart();
			this.handleAddToCartForm();
			this.handleCheckoutOrderForm();
			this.emptyCart();
			this.displayCart();
			this.deleteProduct();
			this.displayUserDetails();


		},

		
		createCart: function () {
			if (this.storage.getItem(this.cartName) == null) {

				var cart = {};
				cart.items = [];

				this.storage.setItem(this.cartName, this._toJSONString(cart));
				this.storage.setItem(this.shippingRates, "0");
				this.storage.setItem(this.total, "0");
			}
		},


		deleteProduct: function () {
			var self = this;
			if (self.$formCart.length) {
				var cart = this._toJSONObject(this.storage.getItem(this.cartName));
				var items = cart.items;

				$(document).on("click", ".pdelete a", function (e) {
					e.preventDefault();
					var productName = $(this).data("product");
					var newItems = [];
					for (var i = 0; i < items.length; ++i) {
						var item = items[i];
						var product = item.product;
						if (product == productName) {
							items.splice(i, 1);
						}
					}
					newItems = items;
					var updatedCart = {};
					updatedCart.items = newItems;

					var updatedTotal = 0;
					var totalQty = 0;
					if (newItems.length == 0) {
						updatedTotal = 0;
						totalQty = 0;
					} else {
						for (var j = 0; j < newItems.length; ++j) {
							var prod = newItems[j];
							var sub = prod.price * prod.qty;
							updatedTotal += sub;
							totalQty += prod.qty;
						}
					}

					self.storage.setItem(self.total, self._convertNumber(updatedTotal));
					self.storage.setItem(self.shippingRates, self._convertNumber(self._calculateShipping(totalQty)));

					self.storage.setItem(self.cartName, self._toJSONString(updatedCart));
					$(this).parents("tr").remove();
					self.$subTotal[0].innerHTML = self.currency + " " + self.storage.getItem(self.total);
				});
			}
		},

		

		displayCart: function () {
			if (this.$formCart.length) {
				var cart = this._toJSONObject(this.storage.getItem(this.cartName));
				var items = cart.items;
				var $tableCart = this.$formCart.find(".shopping-cart");
				var $tableCartBody = $tableCart.find("tbody");

				if (items.length == 0) {
					$tableCartBody.html("");
				} else {


					for (var i = 0; i < items.length; ++i) {
						var item = items[i];
						var product = item.product;
						var price = this.currency + " " + item.price;
						var qty = item.qty;
						var html = "<tr><td class='pname'>" + product + "</td>" + "<td class='pqty'><input type='text' value='" + qty + "' class='qty'/></td>";
						html += "<td class='pprice'>" + price + "</td><td class='pdelete'><a href='' data-product='" + product + "'>&times;</a></td></tr>";

						$tableCartBody.html($tableCartBody.html() + html);
					}

				}

				if (items.length == 0) {
					this.$subTotal[0].innerHTML = this.currency + " " + 0.00;
				} else {

					var total = this.storage.getItem(this.total);
					this.$subTotal[0].innerHTML = total;
				}
			} else if (this.$checkoutCart.length) {
				var checkoutCart = this._toJSONObject(this.storage.getItem(this.cartName));
				var cartItems = checkoutCart.items;
				var $cartBody = this.$checkoutCart.find("tbody");

				if (cartItems.length > 0) {

					for (var j = 0; j < cartItems.length; ++j) {
						var cartItem = cartItems[j];
						var cartProduct = cartItem.product;
						var cartPrice = this.currency + " " + cartItem.price;
						var cartQty = cartItem.qty;
						var cartHTML = "<tr><td class='pname'>" + cartProduct + "</td>" + "<td class='pqty'>" + cartQty + "</td>" + "<td class='pprice'>" + cartPrice + "</td></tr>";

						$cartBody.html($cartBody.html() + cartHTML);
					}
				} else {
					$cartBody.html("");
				}

				if (cartItems.length > 0) {

					var cartTotal = this.storage.getItem(this.total);
					var cartShipping = this.storage.getItem(this.shippingRates);
					var subTot = this._convertString(cartTotal) + this._convertString(cartShipping);

					this.$subTotal[0].innerHTML =  this._convertNumber(subTot);
					
				} else {
					this.$subTotal[0].innerHTML = this.currency + " " + 0.00;
					this.$shipping[0].innerHTML = this.currency + " " + 0.00;
				}

			}
		},

		

		emptyCart: function () {
			var self = this;
			if (self.$emptyCartBtn.length) {
				self.$emptyCartBtn.on("click", function () {
					self._emptyCart();
				});
			}
		},
		

		handleAddToCartForm: function () {
			var self = this;
			self.$formAddToCart.each(function () {
				var $form = $(this);
				var $product = $form.parent();
				var price = self._convertString($product.data("price"));
				var name = $product.data("name");

				$form.on("submit", function () {
					var qty = self._convertString($form.find(".qty").val());
					var subTotal = qty * price;
					var total = self._convertString(self.storage.getItem(self.total));
					var sTotal = total + subTotal;
					self.storage.setItem(self.total, sTotal);
					self._addToCart({
						product: name,
						price: price,
						qty: qty
					});
					var shipping = self._convertString(self.storage.getItem(self.shippingRates));
					var shippingRates = self._calculateShipping(qty);
					var totalShipping = shipping + shippingRates;

					self.storage.setItem(self.shippingRates, totalShipping);
				});
			});
		},

		

		handleCheckoutOrderForm: function () {
			var self = this;
			if (self.$checkoutOrderForm.length) {
				var $sameAsBilling = $("#same-as-billing");
				$sameAsBilling.on("change", function () {
					var $check = $(this);
					if ($check.prop("checked")) {
						$("#fieldset-shipping").slideUp("normal");
					} else {
						$("#fieldset-shipping").slideDown("normal");
					}
				});


			}
		},

	

		_emptyCart: function () {
			this.storage.clear();
		},




		_formatNumber: function (num, places) {
			var n = num.toFixed(places);
			return n;
		},




		_extractPrice: function (element) {
			var self = this;
			var text = element.text();
			var price = text.replace(self.currencyString, "").replace(" ", "");
			return price;
		},



		_convertString: function (numStr) {
			var num;
			if (/^[-+]?[0-9]+\.[0-9]+$/.test(numStr)) {
				num = parseFloat(numStr);
			} else if (/^\d+$/.test(numStr)) {
				num = parseInt(numStr, 10);
			} else {
				num = Number(numStr);
			}

			if (!isNaN(num)) {
				return num;
			} else {
				console.warn(numStr + " cannot be converted into a number");
				return false;
			}
		},



		_convertNumber: function (n) {
			var str = n.toString();
			return str;
		},


		_toJSONObject: function (str) {
			var obj = JSON.parse(str);
			return obj;
		},



		_toJSONString: function (obj) {
			var str = JSON.stringify(obj);
			return str;
		},





		_addToCart: function (values) {
			var cart = this.storage.getItem(this.cartName);

			var cartObject = this._toJSONObject(cart);
			var cartCopy = cartObject;
			var items = cartCopy.items;
			items.push(values);

			this.storage.setItem(this.cartName, this._toJSONString(cartCopy));
		},



		_calculateShipping: function (qty) {
			var shipping = 0;
			if (qty >= 6) {
				shipping = 10;
			}
			if (qty >= 12 && qty <= 30) {
				shipping = 20;
			}

			if (qty >= 30 && qty <= 60) {
				shipping = 30;
			}

			if (qty > 60) {
				shipping = 0;
			}

			return shipping;

		},





		_validateForm: function (form) {
			var self = this;
			var fields = self.requiredFields;
			var $visibleSet = form.find("fieldset:visible");
			var valid = true;

			form.find(".message").remove();

			$visibleSet.each(function () {

				$(this).find(":input").each(function () {
					var $input = $(this);
					var type = $input.data("type");
					var msg = $input.data("message");

					if (type == "string") {
						if ($input.val() == fields.str.value) {
							$("<span class='message'/>").text(msg).
								insertBefore($input);

							valid = false;
						}
					} else {
						if (!fields.expression.value.test($input.val())) {
							$("<span class='message'/>").text(msg).
								insertBefore($input);

							valid = false;
						}
					}

				});
			});

			return valid;

		},




		_saveFormData: function (form) {
			var self = this;
			var $visibleSet = form.find("fieldset:visible");

			$visibleSet.each(function () {
				var $set = $(this);
				if ($set.is("#fieldset-billing")) {
					var name = $("#name", $set).val();
					var email = $("#email", $set).val();
					var city = $("#city", $set).val();
					var address = $("#address", $set).val();
					var zip = $("#zip", $set).val();
					var country = $("#country", $set).val();

					self.storage.setItem("billing-name", name);
					self.storage.setItem("billing-email", email);
					self.storage.setItem("billing-city", city);
					self.storage.setItem("billing-address", address);
					self.storage.setItem("billing-zip", zip);
					self.storage.setItem("billing-country", country);
				} else {
					var sName = $("#sname", $set).val();
					var sEmail = $("#semail", $set).val();
					var sCity = $("#scity", $set).val();
					var sAddress = $("#saddress", $set).val();
					var sZip = $("#szip", $set).val();
					var sCountry = $("#scountry", $set).val();

					self.storage.setItem("shipping-name", sName);
					self.storage.setItem("shipping-email", sEmail);
					self.storage.setItem("shipping-city", sCity);
					self.storage.setItem("shipping-address", sAddress);
					self.storage.setItem("shipping-zip", sZip);
					self.storage.setItem("shipping-country", sCountry);

				}
			});
		}
	};

	$(function () {
		var shop = new $.Shop("#site");
	});

})(jQuery);


